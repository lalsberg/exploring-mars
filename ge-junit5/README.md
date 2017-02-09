##  Migration Tips

`@Before` and `@After` no longer exist; use `@BeforeEach` and `@AfterEach` instead.

`@BeforeClass` and `@AfterClass` no longer exist; use `@BeforeAll` and `@AfterAll` instead.

`@Ignore` no longer exists: use `@Disabled` instead.

`@Category` no longer exists; use `@Tag` instead.

`@RunWith` no longer exists; superseded by `@ExtendWith`.

`@Rule` and `@ClassRule` no longer exist; superseded by `@ExtendWith`; see the following section for partial rule support.

## IDE support

Since 2016.2 IntelliJ IDEA has basic JUnit 5 support. It is not perfect yet, chasing a moving target, but it works and makes playing around with the new JUnit much easier.

The Eclipse team is working on native support as well so expect that shortly.

## Console launcher

Run all tests<br>
`junit-platform-console -p ${path_to_compiled_test_classes} -a`

Run a specific test<br>
`junit-platform-console
    -p ${path_to_compiled_test_classes}
    org.infoq.junit5.HelloWorldTest`

If you do have additional dependencies, for example on other test libraries like Mockito, add them to the class path by listing them behind the -p option.

## Extension Points

`TestExecutionCondition`,`ContainerExecutionCondition`: Can evaluate a condition whose outcome determines whether the tests are executed. An example would be to only run tests on specific operating systems or when some external resource is available.<br>

`TestExecutionExceptionHandler`<br>
This point gets called when a test resulted in an exception. It might be used to roll back a database transaction in case of an error or swallow expected exceptions.<br>

TestInstancePostProcessor,BeforeAll, BeforeEach, AfterEach, AfterAll,BeforeTestExecution, AfterTestExecutionParameterResolver

## Principal motivacao

O junit possui algumas melhorias, mas as principais mudancas estao nos detalhes de implementacao que o tornam muito mais flexivel

## Why Rewrite JUnit?

With development techniques like test-driven development and continuous integration becoming ever more widespread [..] How was JUnit 4 prepared for this? As it turns out, not well. Besides its lone dependency, Hamcrest 1.3, JUnit 4.12 is a monolithic artifact containing the API developers write tests against and the engine running these tests, and that’s it. Discovering tests, for example, had to be implemented again by every tool that wanted to do that.

Unfortunately this was not sufficient to support some advanced tool features. Tool developers often had to improvise by using reflection to access JUnit’s internal APIs, non-public classes, and even private fields. Suddenly implementation details that could otherwise be freely refactored, became de facto parts of the public API. The resulting lock-in made maintenance unpleasant and further improvements difficult.

## Architecture

We have seen how JUnit 4's monolithic architecture made development difficult.<br>
So how is the new version going to change that?

**Separating Concerns**

A test framework has two important tasks:

1. enabling developers to write tests<br>
2. enabling tools to run tests<br>

When pondering the second point for a while it becomes obvious that it contains parts that are identical across different test frameworks. Whether JUnit, TestNg, Spock, Cucumber, ScalaTest, etc., tools typically need a test's name and result, a way to execute tests, they are interested in their reporting hierarchy, etc.

Why repeat code that handles these points across different frameworks? Why require tools to implement specific support for this or that framework (and version) if, on an abstract level, the features are always the same?

### Modularization

Different roles (developers, runtimes, tools) rely on different artifacts:


1. an API for developers to write tests against<br>
2. an engine for each API to discover, present and run the corresponding tests<br>
3. an API that all engines have to implement so they can be used uniformly<br>
4. a mechanism that orchestrates the engines<br>

This separates “JUnit the tool” (1. and 2.) from “JUnit the platform” (3. and 4.). To make this distinction clearer, the project chose to endow it with a naming schema:

The new API we have seen above (and will continue to discuss in the next article) is called **JUnit Jupiter**. It’s what us developers will have the most contact with.<br>

The platform for tools will fittingly be called **JUnit Platform**.<br>

There is also a **JUnit Vintage** subproject, which will adapt JUnit 3 and 4 test to be run by JUnit 5.<br>

## Open Test Alliance

JUnit 5 architecture enables IDEs and build tools to use it as a facade for other testing frameworks (assuming those provide corresponding engines). With this approach tools can uniformly discover, execute, and assess tests without having to implement framework-specific support.

Test failures are typically expressed with exceptions. Unfortunately different test frameworks and assertion libraries do not generally use the same classes but rather implement their own variants (usually extending AssertionError or RuntimeException). This makes interoperability more complex than necessary and prevents uniform handling by tools.

To solve this problem the JUnit Lambda team split off a separate project, the Open Test Alliance for the JVM. This is their proposal:

Based on recent discussions with IDE and build tool developers from Eclipse, Gradle, and IntelliJ, the JUnit Lambda team is working on a proposal for an **open source project to provide a minimal common foundation for testing libraries on the JVM.**

**Compatibility**

Given that JUnit can run test engines for versions 4 and 5 at the same time, it looks like a project can contain tests in both versions. And indeed, JUnit 5 occupies new namespaces: org.junit.jupiter, org.junit.platform, and org.junit.vintage. This means that there will be no conflicts when different JUnit versions are used in parallel and this allows a slow migration to JUnit 5.

Test libraries like Hamcrest and AssertJ, which communicate with JUnit via exceptions, will continue to work in the new version.

#### Fonte
 https://www.infoq.com/articles/JUnit-5-Early-Test-Drive
