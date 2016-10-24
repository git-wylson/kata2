package fr.wd.kata.annotations;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;


public class RunTest {

	public static void main(String[] args) throws Exception {
		System.out.println("Testing...");

		System.out.printf("============================ CLASS =============================");
		Class<TestExample> obj = TestExample.class;
		getClassInfos(obj);

		System.out.println("============================ FIELD =============================");
		getFieldInfos(TestExample.class);
		
		TestExample t =new TestExample();
		t.getHeader();
		 
		

	}


	public static <T> void getFieldInfos(Class<T> clazz){
		for (Field field : clazz.getDeclaredFields()) {

			// if field is annotated with @TesterInfo
			if (field.isAnnotationPresent(TesterInfo.class)) {

				Annotation annotation = field.getAnnotation(TesterInfo.class);
				TesterInfo test = (TesterInfo) annotation;

				System.out.printf("%nField annotation :%s", field.getAnnotations());
				System.out.printf("%nField annotation declarer :%s", field.getDeclaredAnnotations());
				System.out.printf("%nName :%s", field.getName());
				System.out.printf("%nType :%s", field.getType());
				System.out.printf("%nName :%s", test.toString());
				System.out.printf("%nType :%s", test.annotationType());
				System.out.printf("%nPriority :%s", test.priority());
				System.out.printf("%nCreatedBy :%s", test.createdBy());
				System.out.printf("%nTags :");

				int tagLength = test.tags().length;
				for (String tag : test.tags()) {
					if (tagLength > 1) {
						System.out.print(tag + ", ");
					} else {
						System.out.print(tag);
					}
					tagLength--;
				}
				System.out.printf("%nLastModified :%s%n%n", test.lastModified());
			}
		}
	}

	public static <T> void getClassInfos(Class<T> clazz){
		// Process @TesterInfo
		if (clazz.isAnnotationPresent(TesterInfo.class)) {

			Annotation annotation = clazz.getAnnotation(TesterInfo.class);
			TesterInfo testerInfo = (TesterInfo) annotation;

			System.out.printf("%nPriority :%s", testerInfo.priority());
			System.out.printf("%nCreatedBy :%s", testerInfo.createdBy());
			System.out.printf("%nTags :");

			int tagLength = testerInfo.tags().length;
			for (String tag : testerInfo.tags()) {
				if (tagLength > 1) {
					System.out.print(tag + ", ");
				} else {
					System.out.print(tag);
				}
				tagLength--;
			}
			System.out.printf("%nLastModified :%s%n%n", testerInfo.lastModified());
		}
	}

}