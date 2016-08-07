install:
	@./gradlew install
update:
	@./gradlew install --refresh-dependencies
adhoc:
	@./gradlew test --tests Adhoc --stacktrace
idea:
	@./gradlew idea
doc:
	@./gradlew javadoc
clean:
	@./gradlew clean
