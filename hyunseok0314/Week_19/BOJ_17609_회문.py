import sys

input = sys.stdin.readline

N = int(input().rstrip())


def check(word, left, right):
    while left < right and word[left] == word[right]:
        left += 1
        right -= 1

    return left, right


for _ in range(N):
    w = input().rstrip()

    l, r = check(w, 0, len(w) - 1)

    if l >= r:
        print(0)
    else:
        ll, rr = check(w, l + 1, r)

        if ll >= rr:
            print(1)
        else:
            ll, rr = check(w, l, r - 1)

            if ll >= rr:
                print(1)
            else:
                print(2)
