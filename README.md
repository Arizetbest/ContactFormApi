# ContactFormApi
A Simple HTTP API to get contact us form details in mail and to start email thread.

## Technology
<b>JAVA Spring Boot</b>

## Configurations
### Add/Update following details application.properties file
<ul>
  <li>email.smtphost - SMTP Host name</li>
  <li>email.smtpport - SMTP Port Number</li>
  <li>email.emailid - Sender mailid (Email Id from which you want to send mail)</li>
  <li>email.password - Sender password</li>
</ul>

## Form Details
Generally following details are requested in contact us form. 
API takes details in following JSON object format

```
{
    "firstname" : "Chintan",
    "lastname" : "Golakiya",
    "email" : "usermailid@mail.com",
    "subject" : "Mail Subject",
    "message" : "Text based Message"
}
```
## API for localhost
```
http://localhost:5000/contactus
```

## Success Response Example
```
{
    "success": true,
    "message": "Mail Send Successfully!!"
}
```
