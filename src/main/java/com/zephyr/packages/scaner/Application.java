package com.zephyr.packages.scaner;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.zephyr.packages.scaner.utils.CommonPackagesScaner;
import com.zephyr.packages.scaner.utils.CommonPackagesScaner.HQScanPackageFilter;
import com.zephyr.packages.scaner.utils.CommonPackagesScaner.HQScanPackageListener;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello world.");
		@SuppressWarnings("rawtypes")
		List<Class> clzes = new ArrayList<>();
		CommonPackagesScaner scanPackage = new CommonPackagesScaner();
		scanPackage.addPackage(CommonPackagesScaner.class.getPackage().getName());
		scanPackage.setFilter(new HQScanPackageFilter() {

			@Override
			public boolean accept(Class<?> clazz) {
				return true;
			}
		});
		scanPackage.setListener(new HQScanPackageListener() {

			@Override
			public void onScanClass(Class<?> clazz) {
				clzes.add(clazz);
				System.out.println(clazz);
			}
		});
		scanPackage.scan();

		for (Class cls : clzes) {
			System.out.println("##"+cls.getName());
//			Annotation[] annotations = cls.getAnnotations();
//			for (Annotation annotation : annotations) {
//				System.out.println("%%%%%%%%%%%%%%%"+annotation.annotationType().getName());
//			}
			try {
				Method[] ms = cls.getDeclaredMethods();
				for (Method m : ms) {
					System.out.println("$$$$"+m.getName());
					Annotation[] annotations = m.getAnnotations();
					for (Annotation annotation : annotations) {
						System.out.println("%%%%%%%%%%%%%%%"+annotation.annotationType().getName());
					}

				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
