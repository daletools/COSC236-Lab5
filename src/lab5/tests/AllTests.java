package lab5.tests;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite

@SelectClasses({ TestAddRemoveBooks.class, TestAddRemoveMembers.class, TestFindClassString.class, TestBorrowBooks.class,
		TestNotAvailableBook.class, TestRemoveMemberWithBooks.class, TestController.class,
		TestMembersBorrowingService.class, TestSingleton.class, BookFactoryTests.class })

public class AllTests {
	// No need for test methods here; the suite will run the included classes
}
