#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false); // Fast I/O
    cin.tie(nullptr);

    int n, m, k;
    cin >> n >> m >> k;

    vector<int> desired(n);
    vector<int> apartments(m);

    for (int i = 0; i < n; ++i) cin >> desired[i];
    for (int i = 0; i < m; ++i) cin >> apartments[i];

    sort(desired.begin(), desired.end());
    sort(apartments.begin(), apartments.end());

    int i = 0, j = 0, count = 0;

    while (i < n && j < m) {
        if (apartments[j] < desired[i] - k) {
            j++; // apartment too small
        } else if (apartments[j] > desired[i] + k) {
            i++; // apartment too big
        } else {
            count++; // match found
            i++;
            j++;
        }
    }

    cout << count << '\n';

    return 0;
}
