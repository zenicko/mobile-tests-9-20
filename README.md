<img src="readme-images/browserStack-logo.png" height="50" width="50"> <b>BrowserStack</b>
<img src="readme-images/appium-logo.png" height="50" width="50"> <b>Appium</b>

# I'm readme file and will tell about the project
___
How can test mobile apps? Ok, I'll tell you. Let's start!

## Acknowledgements
___
[Vasenkov Stanislav](https://github.com/svasenkov)

[Eugen Paraschiv(Baeldung)](https://twitter.com/baeldung)

[Maintenance and technical support website https://browserstack.com](https://browserstack.com)

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
4. Check the default code language is `EN`
   1. resource-id	org.wikipedia.alpha:id/search_lang_button
      1. text `EN`
  
5. Check a code language. Change the default language and check code language. 
(parametrs: code language, field.text `localized_language_name` 
and field.text `language_subtitle`)
   Step 1. Click on search field:
      1. resource-id	org.wikipedia.alpha:id/preference_languages_filter
      2. class	android.widget.EditText
   Step 2. Send text: `Russian`
   Step 3. Check exist fields:
      1. resource-id	org.wikipedia.alpha:id/localized_language_name
         1. text	`Русский`
      2. resource-id	org.wikipedia.alpha:id/language_subtitle
         1. text	`Russian`
   Step 4. Choose the language of `Russian`.
   Step 5. Check a short name in the language panel. Must be `RU`   
6. Hide sensitive data by `Owner` and URLs
   1. Created the file `app.properties` with properties: 
```
   browserstack.user=Add username on BrowserStack
   browserstack.key=Add password on BrowserStack
   browserstack.networkLogs=true
   browserstack.app=Add app id
   #Example bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c
   browserstack.url=http://hub.browserstack.com/wd/hub
   browserstack.url.statSession=https://api-cloud.browserstack.com/app-automate/sessions/
```
   2. Created the file `local.properties` with properties (default): 
```
   device=Google Pixel 3
   os_version=9.0
   # Set other BrowserStack capabilities
   project=First Java Project
   build=browserstack-build-1
   name=first_test
```

7.* Create job in Jenkins

8.* Import to Allute TestOps

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
1. [Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5)

## Miscellaneous
___
1. [Коды языков](https://ru.wikipedia.org/wiki/%D0%9A%D0%BE%D0%B4%D1%8B_%D1%8F%D0%B7%D1%8B%D0%BA%D0%BE%D0%B2)
2. [ISO 639](https://ru.wikipedia.org/wiki/ISO_639)
