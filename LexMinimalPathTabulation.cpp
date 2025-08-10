#include <bits/stdc++.h>
using namespace std;

int n;
char grid[3005][3005];

struct Pos {
    int i, j;
    Pos(int x, int y) : i(x), j(y) {}
    bool operator<(const Pos& other) const {
        return tie(i, j) < tie(other.i, other.j);
    }
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);

    cin >> n;
    for (int i = 0; i < n; ++i)
        cin >> grid[i];

    string ans = "";
    set<Pos> curr;
    curr.insert(Pos(0, 0));
    ans += grid[0][0];

    for (int step = 1; step < 2 * n - 1; ++step) {
        char minChar = 'Z' + 1;
        set<Pos> next;

        for (auto [i, j] : curr) {
            if (i + 1 < n) {
                minChar = min(minChar, grid[i + 1][j]);
            }
            if (j + 1 < n) {
                minChar = min(minChar, grid[i][j + 1]);
            }
        }

        for (auto [i, j] : curr) {
            if (i + 1 < n && grid[i + 1][j] == minChar)
                next.insert(Pos(i + 1, j));
            if (j + 1 < n && grid[i][j + 1] == minChar)
                next.insert(Pos(i, j + 1));
        }

        ans += minChar;
        curr = move(next);  // move for performance
    }

    cout << ans << "\n";
    return 0;
}
