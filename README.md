<img src="readme-images/browserStack-logo.png" height="50" width="50"> <b>BrowserStack</b>
<img src="readme-images/appium-logo.png" height="50" width="50"> <b>Appium</b>

# I'm readme file and will tell about the project
___
How can test mobile apps? Ok, I'll tell you. Let's start!


## Acknowledgements
___
[Vasenkov Stanislav](https://github.com/svasenkov)

## About the homework
___
- Зарегистрировать аккаунт в browserstack
- Запустить автотест с примером из browserstack локально
- Разработать еще один автотест, используя инспектор browserstack (простейший тест)
- Добавить аллюровские степы
- Вынести данные (логин, пароль, урл браузерстека и т.д.) в .properties с owner
- Сделать сборку в дженкинсе
- Добавить проект в TestOps

## Steps
___
1. Created basic structure of the project: directories and files(.gitignore, build.gradle and readme.md). 
2. Used (Appium) the example of automation test from site BrowserStack class `AndroidBrowserStackSampleTests.java`. 
3. Used Selenide in the test. Refactored code class `AndroidBrowserStackSampleTests.java`. 
Create classes `TestBase`,`AndroidTests` and `BrowserStackMobileDriver`.

## What's new?
___
1. Selenide.java
```
   /**
    * Open an empty browser (without opening any pages).
    * E.g. useful for starting mobile applications in Appium.
   */
      public static void open() {
            getSelenideDriver().open();
      }
```
## Resources
___


## Miscellaneous
___



