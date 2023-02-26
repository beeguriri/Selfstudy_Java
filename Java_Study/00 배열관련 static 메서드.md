💜 배열을 다루기 편리한 static 메서드

```java
//배열의 출력 (오버로딩)
static String toString(int[] a)
Arrays.toString(arr) //1차원배열
Arrays.deepToString(2d-arr) //다차원배열
    ...

//배열의 복사 -> 새로운 배열 만들어줌
int [] arr = {0, 1, 2};
int [] arr2 = Arrays.copyOf(arr, 2); //[0, 1]
int [] arr3 = Arrays.copyOfRange(arr,2,4);	//[2,0]

//배열채우기
int [] arr = new int[5];
Arrays.fill(arr, 9); //arr = [9,9,9,9,9];
Arrays.setAll(arr, (i) -> (int)(Math.random()*5)+1); //(람다식 이용) arr = [1,5,2,1,1] 

//정렬
Arrays.sort(arr);
Arrays.binarySearch(arr,2)	//인덱스 반환, 정렬필수
    
//배열을 list로 변환
//list는 읽기전용이므로 list.add가 안됨
//새로운 list를 만들어서 사용하면 변경 가능
Arrays.asList(new Integer[]{1,2,3,4,5});
Arrays.asList(1,2,3,4,5);
```

