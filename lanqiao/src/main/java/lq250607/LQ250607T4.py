def main():
    l_val, r_val = map(int, input().split())

    def solve(n):
        if n <= 0:
            return 0
        max_len = 10
        num_str = str(n)
        len_n = len(num_str)
        digits = [0] * (max_len - len_n) + [int(d) for d in num_str]

        from functools import lru_cache

        @lru_cache(maxsize=None)
        def dp(i, tight, found, state):
            if i == max_len:
                return (1, 0) if found else (0, 0)

            total_count = 0
            total_sum = 0
            low = 0
            high = digits[i] if tight else 9

            for d in range(low, high + 1):
                new_tight = tight and (d == high)
                power = 10 ** (9 - i)

                if found:
                    count_next, sum_next = dp(i + 1, new_tight, True, 0)
                    if count_next > 0:
                        total_count += count_next
                        total_sum += d * power * count_next + sum_next
                else:
                    new_state = next_state(state, d)
                    if new_state == 4:
                        count_next, sum_next = dp(i + 1, new_tight, True, 0)
                        if count_next > 0:
                            total_count += count_next
                            total_sum += d * power * count_next + sum_next
                    else:
                        count_next, sum_next = dp(i + 1, new_tight, False, new_state)
                        if count_next > 0:
                            total_count += count_next
                            total_sum += d * power * count_next + sum_next

            return (total_count, total_sum)

        def next_state(s, d):
            if s == 0:
                if d == 4:
                    return 1
                else:
                    return 0
            elif s == 1:
                if d == 9:
                    return 2
                elif d == 4:
                    return 1
                else:
                    return 0
            elif s == 2:
                if d == 3:
                    return 3
                elif d == 4:
                    return 1
                else:
                    return 0
            elif s == 3:
                if d == 1:
                    return 4
                elif d == 4:
                    return 1
                else:
                    return 0

        count, total_sum = dp(0, True, False, 0)
        return total_sum

    ans = solve(r_val) - solve(l_val - 1)
    print(ans)


if __name__ == '__main__':
    main()