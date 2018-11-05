
## cssSelector
```java
//Loginsection classının 1 altında forgotPassword idli eleman
By test = By.cssSelector(".loginSection > #forgotPassword"); 


By test2 = By.cssSelector(".resultListGroup .header .resultText strong");
//Daha kısa daha iyi 
By test3 = By.cssSelector(".resultText > strong"); 


By passwordField = By.cssSelector("#loginForm input[type='password']");
//yada
By passwordField = By.id("password")

//a[title='telefon tutucu'] a taglı elemanın title ı "telefon tutucu" olan element

```

## XPATH
```java
//loginForm altındaki password id li field
By passwordXpath = By.xpath("//*[@id='loginForm']//*[@id='password']");

//password fieldı
By passwordByXpath2 = By.xpath("//*[@id='password']");
```