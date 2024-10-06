#include <iostream>
#include <deque>
#include <map>
#include <vector>
using namespace std;
int n,k;
int dp[1001][10001];//i번째 과목까지 공부, j시간 공부했을 때의 최대 중요도
int import[1001], duration[1001];

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin>>n>>k;// 최대공부시간, 과목수
    for(int i=1; i<=k; i++) {
        cin>>import[i]>>duration[i];
    }

    for(int i=1; i<=k; i++) { //현재 과목
        for(int j=1; j<=n; j++) { //현재 공부시간
            dp[i][j]=dp[i-1][j]; //이번꺼 안넣음
            if(j-duration[i]>=0) { //이번꺼 넣을 수 있으면
                dp[i][j]=max(dp[i][j], dp[i-1][j-duration[i]]+import[i]);
            }
        }
    }
    cout<<dp[k][n];
    return 0;
}
