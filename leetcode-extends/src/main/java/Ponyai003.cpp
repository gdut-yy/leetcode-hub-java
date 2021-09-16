#include <queue>
#include <vector>
#include <algorithm>
#include <iostream>
#include <ios>
#include <tuple>
#include <utility>
#include <limits>
#include <functional>
#include <cassert>
using namespace std;


int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    //cout.tie(nullptr);
    int N;
    cin>>N;
    // type, coord1, coord2_start, coord2_end
    vector<tuple<int,int,int,int>> roads;
    for(int i = 0; i < N; i++){
        int x1, y1, x2, y2;
        cin>>x1>>y1>>x2>>y2;
        if(x1 == x2){
            if(y1 > y2){
                swap(y1, y2);
            }
            roads.emplace_back(0, x1, y1, y2);
        }else{
            if(x1 > x2){
                swap(x1, x2);
            }
            roads.emplace_back(1, y1, x1, x2);
        }
    }
    int SX, SY, TX, TY;
    long T1, T2, T3;
    cin>>SX>>SY>>TX>>TY>>T1>>T2>>T3;
    if(SX == TX && SY == TY){
        cout<<0<<endl;
        return 0;
    }
    sort(roads.begin(), roads.end());
    int H;
    for(H = 0; H < roads.size(); H++){
        if(get<0>(roads[H]) == 1){
            break;
        }
    }
    // x, y
    vector<tuple<int,int>> nodes;
    // dir: 0: (1, 0); 1: (0, 1); 2: (-1, 0); 3: (0, -1)
    // id, dir, dist
    vector<vector<tuple<int,int,int>>> graph;
    vector<int> last_node(N - H, -1);
    int source_id = -1, target_id = -1;
    auto add_node = [&](int nx, int ny){
        //cout<<"add_node "<<nx<<" "<<ny<<endl;
        if(nx == SX && ny == SY){
            source_id = (int)nodes.size();
        }
        if(nx == TX && ny == TY){
            target_id = (int)nodes.size();
        }
        nodes.emplace_back(nx, ny);
        graph.emplace_back();
        return (int)nodes.size() - 1;
    };
    auto _add_segment = [&](int from, int to, int dist, int dir){
        graph[from].emplace_back(to, dir, dist);
        graph[to].emplace_back(from, (dir + 2) % 4, dist);
    };
    auto add_segment = [&](int from, int to, int cx, int cy, int nx, int ny){
        int dir, dist;
        if(cx == nx){
            dir = 1;
            if(cx == SX && cy < SY && SY < ny){
                if(cx == TX && cy < TY && TY < ny){
                    target_id = add_node(TX, TY);
                    source_id = add_node(SX, SY);
                    if(TY < SY){
                        _add_segment(from, target_id, TY - cy, dir);
                        _add_segment(target_id, source_id, SY - TY, dir);
                        _add_segment(source_id, to, ny - SY, dir);
                    }else{
                        _add_segment(from, source_id, SY - cy, dir);
                        _add_segment(source_id, target_id, TY - SY, dir);
                        _add_segment(target_id, to, ny - TY, dir);
                    }
                }else{
                    source_id = add_node(SX, SY);
                    _add_segment(from, source_id, SY - cy, dir);
                    _add_segment(source_id, to, ny - SY, dir);
                }
            }else if(cx == TX && cy < TY && TY < ny){
                target_id = add_node(TX, TY);
                _add_segment(from, target_id, TY - cy, dir);
                _add_segment(target_id, to, ny - TY, dir);
            }else{
                _add_segment(from, to, ny - cy, dir);
            }
        }else{
            dir = 0;
            if(cy == SY && cx < SX && SX < nx){
                if(cy == TY && cx < TX && TX < ny){
                    target_id = add_node(TX, TY);
                    source_id = add_node(SX, SY);
                    if(TX < SX){
                        _add_segment(from, target_id, TX - cx, dir);
                        _add_segment(target_id, source_id, SX - TX, dir);
                        _add_segment(source_id, to, nx - SX, dir);
                    }else{
                        _add_segment(from, source_id, SX - cx, dir);
                        _add_segment(source_id, target_id, TX - SX, dir);
                        _add_segment(target_id, to, nx - TX, dir);
                    }
                }else{
                    source_id = add_node(SX, SY);
                    _add_segment(from, source_id, SX - cx, dir);
                    _add_segment(source_id, to, nx - SX, dir);
                }
            }else if(cy == TY && cx < TX && TX < nx){
                target_id = add_node(TX, TY);
                _add_segment(from, target_id, TX - cx, dir);
                _add_segment(target_id, to, nx - TX, dir);
            }else{
                _add_segment(from, to, nx - cx, dir);
            }
        }
        return to;
    };
    auto add_cross = [&](int from1, int from2, int nx, int ny){
        int cx1, cy1, cx2, cy2;
        tie(cx1, cy1) = nodes[from1];
        tie(cx2, cy2) = nodes[from2];
        if(cx1 == nx && cy1 == ny){
            add_segment(from2, from1, cx2, cy2, nx, ny);
            return from1;
        }else if(cx2 == nx && cy2 == ny){
            add_segment(from1, from2, cx1, cy1, nx, ny);
            return from2;
        }else{
            int to = add_node(nx, ny);
            add_segment(from1, to, cx1, cy1, nx, ny);
            add_segment(from2, to, cx2, cy2, nx, ny);
            return to;
        }
    };
    int current_node = -1;
    int cx = -1, cy = -1;
    for(int i = 0; i < H; i++){
        int vx, vy1, vy2;
        tie(ignore, vx, vy1, vy2) = roads[i];
        //cout<<"Processing road "<<i<<" ("<<vx<<", "<<vy1<<", "<<vy2<<")"<<endl;
        if(current_node < 0 || cx != vx || cy != vy1){
            current_node = add_node(vx, vy1);
            cx = vx;
            cy = vy1;
        }
        for(int j = H; j < roads.size(); j++){
            int hy, hx1, hx2;
            tie(ignore, hy, hx1, hx2) = roads[j];
            // Cross?
            if(hx1 <= vx && vx <= hx2 && vy1 <= hy && hy <= vy2){
                int from;
                if(last_node[j - H] < 0){
                    if(cx == hx1 && cy == hy){
                        // Same node
                        last_node[j - H] = current_node;
                        from = current_node;
                    }else{
                        from = add_node(hx1, hy);
                    }
                }else{
                    from = last_node[j - H];
                }
                if(from != current_node){
                    last_node[j - H] = current_node = add_cross(current_node, from, vx, hy);
                    cy = hy;
                }
            }
        }
        if(cy != vy2){
            int to = add_node(vx, vy2);
            current_node = add_segment(current_node, to, cx, cy, vx, vy2);
            cy = vy2;
        }
    }
    for(int j = H; j < roads.size(); j++){
        int hy, hx1, hx2, from;
        tie(ignore, hy, hx1, hx2) = roads[j];
        from = last_node[j - H];
        if(from < 0){
            from = add_node(hx1, hy);
        }
        int cx, cy;
        tie(cx, cy) = nodes[from];
        if(cx != hx2){
            int to = add_node(hx2, hy);
            add_segment(from, to, cx, cy, hx2, hy);
        }
    }
    assert(source_id >= 0);
    assert(target_id >= 0);
    //cout<<"source_id "<<source_id<<" target_id "<<target_id<<endl;
    auto next_time = [&](long current_time, int dir1, int dir2, int dist)->long{
        int chdir = (dir2 + 4 - dir1) % 4;
        if(chdir == 2){
            return numeric_limits<long>::max();
        }else if(chdir == 3){
            return current_time + dist;
        }else if(chdir == 0){
            long r = current_time % (T1 + T2 + T3);
            // T1 <= next_time % (T1 + T2 + T3) < T1 + T2 + T3
            if(r >= T1){
                return current_time + (long)dist;
            }else{
                return current_time + T1 - r + (long)dist;
            }
        }else if(chdir == 1){
            long r = current_time % (T1 + T2 + T3);
            // T1 <= next_time % (T1 + T2 + T3) < T1 + T2
            if(r >= T1 && r < T1 + T2){
                return current_time + (long)dist;
            }else if(r < T1){
                return current_time + T1 - r + (long)dist;
            }else{
                return current_time + T1 + T2 + T3 - r + T1 + (long)dist;
            }
        }
    };

    vector<long> dist(nodes.size() * 4, numeric_limits<long>::max());
    priority_queue<tuple<long, int, int>, vector<tuple<long, int, int>>,
                   greater<tuple<long, int, int>>> queue;
    for(int dir = 0; dir < 4; dir++){
        queue.emplace(0, source_id, dir);
        dist[source_id * 4 + dir] = 0;
    }
    while(!queue.empty()){
        long d;
        int node_id, dir;
        tie(d, node_id, dir) = queue.top();
        //cout<<"("<<node_id<<", "<<dir<<") -> "<<d<<endl;
        if(node_id == target_id){
            cout<<d<<endl;
            return 0;
        }
        queue.pop();
        for(auto &&edge: graph[node_id]){
            int id2, dir2, dist2;
            tie(id2, dir2, dist2) = edge;
            assert(id2 >= 0 && id2 < nodes.size());
            assert(0 <= dir2 && dir2 < 4);
            long nt;
            if(node_id == source_id){
                nt = d + dist2;
            }else{
                nt = next_time(d, dir, dir2, dist2);
            }
            if(nt < dist[id2 * 4 + dir2]){
                dist[id2 * 4 + dir2] = nt;
                //cout<<"update ("<<id2<<", "<<dir2<<") -> "<<nt<<endl;
                queue.emplace(nt, id2, dir2);
            }
        }
    }
    cout<<"-1"<<endl;
    return 0;
}