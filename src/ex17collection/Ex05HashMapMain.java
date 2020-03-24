package ex17collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/*
HashMap<K,V> 
	: Map<T> 인터페이스를 구현한 컬랙션 클래스로
	- Key, Value의 쌍으로 객체를 저장한다.
	- 키값은 중복될 수 없다. 중복될 경우 덮어쓰기 처리되고 저장되있던 값은 반환된다..
	- 키값으로 검색하므로 다른 컬랙션보다 속도가 빠르다\
	- 입력된 순서를 보장한다.
 */
public class Ex05HashMapMain {

	public static void main(String[] args) {
		
		//Map컬렉션 생성. 여기서 Key 와 Value는 String형으로 선언함.
		HashMap<String, String> map =
				new HashMap<String, String>();
		
		
		/*
		객체저장
			: 객체 저장시 기존에 저장된 동일한 키값이 존재하면 이전 객체가 반환된다.
			만약 처음이라면 null값이 반환된다.
		 */
		System.out.println("name이라는 키값으로 저장된 이전의 값:"+ 
				map.put("name", "홍길동"));//->null 반환됨
		
		int number = 20;
//		map.put("age", number);//Value타입이 String과 맞지 않아 Integer타입이므로 에러발생
		map.put("age", String.valueOf(number));
		map.put("gender", "남자");
		map.put("address", "가산디지털단지");
		
		/*
		3] 객체수
		 */
		System.out.println("저장된 객체수:"+ map.size());//4
		
		
		/*
		4] 중복저장
			: 기존에 입력된 name 이라는 key값이 있으므로 "홍길동"이 출력된다.
			그리고 기존의 값이 "최길동"으로 갱신된다.
		 */
		System.out.println("name이라는 키값으로 저장된 이전의 값:"+
				map.put("name", "최길동"));//덮어쓰기 처리
		System.out.println("키값으로 중복 저장후 객체수:"+
				map.size());//4
		
		/*
		5]출력
		5-1] 키값을 알고있을때 출력하기
			: get(키값) 으로 value 출력
		 */
		System.out.println("키값을 알때:"+map.get("name"));
		
		/*
		5-2] 키값을 모를때 출력하기
			1. Set<T> keySet() 메소드 호출을 통해 키값들을 Set계열의 
				컬렉션 형태로 가져온다.
			2. Map계열의 컬렉션에는 처음부터 확장 for문을 사용하는 것이 불가능하다.
			3. 키값을 얻어온후 확장for문을 통해 key값을 하나씩 출력한다.
		 */
		//키값을 얻어온것을 String형의 Set컬렉션에 저장
		Set<String> keys = map.keySet();//=> [address, gender, name, age]
		System.out.println(keys);
		System.out.println("[확장for문 적용]");
		
		for(String key : keys) {
			String value = map.get(key);
			System.out.println(
					String.format("%s:%s", key,value));
		}
		
		/*
		5-3] 반복자를 통한 출력
			: iterator를 통해 반복할때도 keySet()으로 키값을
			먼저 얻어온 후 사용할 수 있다.
		 */
		
		System.out.println("[반복자 사용하기]");
		Set<String> keys2 = map.keySet();
		Iterator<String> it = keys2.iterator();
		
		while(it.hasNext()) {
			String key = it.next();//키값얻기
			String value = map.get(key);//벨류값얻기
			System.out.println(
					String.format("%s:%s", key, value));
		}
		
		
		/*
		5-4] value 값만 얻어올때 : values() 메소드 사용
		 */
		System.out.println("[value값들만 출력하기]");
		Collection<String> values = map.values();
		System.out.println(values);//[가산디지털단지, 자웅동체, 최길동, 30]
		for(String value : values) {
			System.out.println(value);
		}
		
		
		
		
		
		
		
		
		
		
		
		/*
		6] 존재유무판단
			: 존재할 경우 ture를 반환한다.
		 */
		
		System.out.println(map.containsKey("name")?
				"name키값있다":"name키값없다");
		System.out.println(map.containsKey("account")?
				"account키값있다":"account키값없다");
		System.out.println(map.containsValue("여자")?
				"여자 값있다":"여자 값 없다");
		
		
		/*
		7]삭제
			: key값을 통해 삭제하고, 삭제가 완료되면 해당 값(또는 객체)가 반환된다.
		 */
		System.out.println("삭제된객체:"+map.remove("age"));
		System.out.println("[age키값을 삭제후 출력]");
		
		for(String key : keys) {
			System.out.println(
					String.format("%s:%s", key, map.get(key)));
		}
		
		
		//8] 전체삭제 : removeAll()은 없음.
		map.clear();
		System.out.println("전체삭제후 객체수:"+ map.size());
		
		
		
	}
}





























