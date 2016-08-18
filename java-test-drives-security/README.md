#2b2bsecurity

## CredentialsReader example

* Generate key store
```
$ openssl genrsa 1024 > server.key
$ openssl req -new -x509 -nodes -sha1 -days 365 -key server.key > server.cert
$ openssl pkcs12 -export -out keyStore.p12 -in server.cert -inkey server.key
```

* Check your data
```
$ keytool -list -v -keystore keyStore.p12 -storetype PKCS12
$ keytool -list -keystore keyStore.p12
```

* Others

```
$ openssl req -new -key server.key -out server.csr
$ openssl x509 -req -days 365 -in server.csr -signkey server.key -out server.crt
$ openssl x509 -inform DER -outform PEM -in server.crt -out server.crt.pem
$ openssl pkcs12 -export -out keyStore.p12 -inkey myKey.pem -in certs.pem
$ openssl pkcs12 -export -chain -out keyStore.p12 -in server.cert -inkey server.key -name "alias"
$ openssl req -new -x509 -nodes -sha1 -days 365 -key server.key > server.cert

```

## References:

* http://www.akadia.com/services/ssh_test_certificate.html

* https://www.sslshopper.com/article-most-common-openssl-commands.html

* http://www.panojohnson.com/misc/java-cert-parsing.html
