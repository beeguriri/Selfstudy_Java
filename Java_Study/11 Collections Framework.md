#### Collections Framework 

- 다수의 데이터를 다루기 위함

- 인터페이스 : List, Set, Map...

- Collection 인터페이스  : List, Set의 공통점을 모아 구현

  - List : 저장순서 O, 데이터 중복 O
    - ArrayList
    - LinkedList
    - Stack

  - Set : 저장순서 X, 데이터 중복 X 
    - HashSet
    - TreeSet

  - Map : `KEY:VALUE` 저장순서X, 키는 중복X, 값은 중복O 
    - HashMap (LinkedHashMap은 순서가 있음)
    - TreeMap



##### List 인터페이스 

```java
//추가
void add(int index, Object element)
boolean addAll(int index, Collection c)

//삭제
Object remove(int index)
    
//검색
int indexOf(Object o)
int lastIndexOf (Object o)
    
//읽기, 쓰기(변경)
Object get (int index)
Object set (int index, Object element)
    
//정렬
void sort(Comparator c)

```



##### Set 인터페이스 : Collection 인터페이스와 동일

```java
boolean addAll(Collection c)		//합집합
boolean containsAll(Collection c)	//부분집합
boolean removeAll(Collection c)		//차집합 
boolean retainAll(Collection c)		//교집합
```



##### Map 인터페이스

```java
//추가
Object put(Object key, Object value)

//삭제
Object remove(Object key)
    
//검색
Object get(Object key)
boolean containsKey(Object key)
boolean containsValue(Object value)

//맵에 저장된 값 읽어올 때
Set entrySet()		//Set으로 반환
Set keySet()		//Set으로 반환
Collection values()	//List, Set 등으로 반환
```

#### 