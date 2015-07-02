package javalanguage.generic;

public class 吃不了饺子 {


	// Generic singleton factory pattern
	private static 看电影去<Object> IDENTITY_FUNCTION = new 看电影去<Object>() {
		public Object apply(Object arg) {
			return "--------->>>>"+arg;
		}
	};

	// IDENTITY_FUNCTION is stateless and its type parameter is
	// unbounded so it's safe to share one instance across all types.
	@SuppressWarnings("unchecked")
	public static <T> 看电影去<T> identityFunction() {
		return (看电影去<T>) IDENTITY_FUNCTION;
	}

	// Sample program to exercise generic singleton
	public static void main(String[] args) {
		String[] strings = { "jute", "hemp", "nylon" };
		看电影去<String> sameString = identityFunction();
		for (String s : strings)
			System.out.println(sameString.apply(s));
		Number[] numbers = { 1, 2.0, 3L };
		看电影去<Number> sameNumber = identityFunction();
		for (Number n : numbers)
			System.out.println(sameNumber.apply(n));
	}

}
