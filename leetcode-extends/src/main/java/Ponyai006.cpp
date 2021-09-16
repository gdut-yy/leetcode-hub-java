#include <unordered_map>
#include <vector>
#include <iostream>
using namespace std;


int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int T;
    cin>>T;
    vector<int> array;
    vector<int> smaller_count;
    vector<int> num_ids[10];
    int num_ids_ptr[10];
    int num_ids_ptr_sum[10];
    for(int __loop = 0; __loop < T; __loop++){
        int K, N;
        cin>>K>>N;
        array.resize(N);
        smaller_count.resize(N);
        for(int i = 0; i < N; i++){
            cin>>array[i];
        }
        for(int i = 0; i < 10; i++){
            num_ids[i].clear();
            num_ids_ptr[i] = 0;
            num_ids_ptr_sum[i] = 0;
        }
        for(int i = 0; i < N; i++){
            int c = 0;
            for(int j = 0; j < array[i]; j++){
                c += (int)num_ids[j].size();
            }
            smaller_count[i] = c;
            num_ids[array[i]].push_back(i);
        }
        if(N == 1){
            cout<<array[0]<<endl;
            continue;
        }
        bool first = true;
        int last2[2];
        for(int i = 0; i < N; i++){
            for(int j = 9; j >= 0; j--){
                if(num_ids_ptr[j] < num_ids[j].size()){
                    int next_id = num_ids[j][num_ids_ptr[j]];
                    int price = smaller_count[next_id] - num_ids_ptr_sum[j];
                    //cout<<"try "<<j<<", next_id="<<next_id<<", price="<<price<<endl;
                    if(price <= K){
                        K -= price;
                        if(i < N - 2){
                            if(first){
                                first = false;
                            }else{
                                cout<<" ";
                            }
                            cout<<j;
                        }else{
                            last2[i + 2 - N] = j;
                        }
                        num_ids_ptr[j]++;
                        for(int j2 = j + 1; j2 < 10; j2++){
                            num_ids_ptr_sum[j2]++;
                        }
                        break;
                    }
                }
            }
        }
        if(K){
            for(int j = 0; j < 10; j++){
                if(num_ids[j].size() > 1){
                    K = 0;
                    break;
                }
            }
            if(K % 2){
                swap(last2[0], last2[1]);
            }
        }
        for(int i = 0; i < 2; i++){
            if(first){
                first = false;
            }else{
                cout<<" ";
            }
            cout<<last2[i];
        }
        cout<<"\n";
    }
    return 0;
}