
// 不要和傻逼过不去，尤其这个傻逼不是你自己 2022/2/15 基于一次失败的睡前一题
#include<iostream>
#include <stack>
using namespace std;
// 两种写法
// int getstacklast(stack<int> &st){
//     int result = st.top();
//     st.pop();
//     if(st.empty())
//         return result;
//     int last = getstacklast(st);
//     st.push(result);
//     return last;
// }
// void reverse(stack<int>&st){
//     if(st.size()==1 ||st.empty())
//         return;
//     int n = getstacklast(st);
//     reverse(st);
//     st.push(n);
// }
void reverse(stack<int>&st){
    if(st.size()<=1)
        return;
    int n = st.top();
    st.pop();
    reverse(st);
    int n1 = st.top();
    st.pop();
    reverse(st);
    st.push(n);
    reverse(st);
    st.push(n1);
}
int main(){
    stack<int> st;
    for(int i = 0; i< 10; i++){
        st.push(i);
    }
    reverse(st);
    while(!st.empty()){
        cout<<st.top()<<endl;
        st.pop();
    }
    return 0;
}

