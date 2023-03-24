#### DFS/BFS (그래프 탐색 알고리즘)

+ Stack : Last-In Last-Out

```jav
Stack<Integer> s = new Stack<>();
s.push()
s.pop()
s.peak()
```



+ Queue : First-In First=Out

```java
Queue<Integer> q = new LinkedList<>();
q.offer();
q.poll();
```



+ 재귀함수(Recursive Function)
  + 반드시 재귀함수의 종료 조건 명시

```java
//팩토리얼
static int factorial (int n) {

    if(n>0) return n*factorial(n-1);
    else	return 1;
}
```

```java
//유클리드 호제법
public int GCD(int a, int b) {
    if(b==0) return a;
    else return GCD(b, a%b);
}
```



+ DFS (Depth-First Search, 깊이 우선 탐색)
  + 탐색 시작 노드를 스택에 삽입하고 방문 처리
  + 스택의 최상단 노드에 방문하지 않은 인접한 노드가 하나라도 있으면 그 노드를 스택에 넣고 방문 처리
  + 방문하지 않은 인접한 노드가 없으면 스택에서 최상단 노드 pop
  + ![image-20230324203900397](https://github.com/beeguriri/Java_SelfStudy/blob/main/Java_Study/images/DFS_1.png?raw=true)
  + 노드의 탐색순서 : 1 -> 2 -> 7 -> 6 -> 8 -> 3 -> 4 -> 5
  + [JAVA코드](https://github.com/ndb796/python-for-coding-test/blob/master/5/8.java)

​					

+ BFS(Breadth-First Search, 너비우선탐색)
  + 탐색 시작 노드를 `큐`에  삽입하고 방문처리
  + 큐에서 노드를 꺼낸 뒤 해당노드의 인접 노드 중 방문하지 않은 노드를 모두 큐에 삽입하고 방문 처리
  + 노드의 탐색순서 : 1 -> 2 -> 3 -> 8 -> 7 -> 4 -> 5 -> 6
  + 최단거리 문제 해결을 위해 사용
  + [JAVA코드](https://github.com/ndb796/python-for-coding-test/blob/master/5/9.java)