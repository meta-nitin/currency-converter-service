# currency-converter-service
A simple micro service that talks to another micro service (currency-exchange-service) to convert given amount in a given currency to another given currency. It is a spring cloud client project that makes use of Feign, Ribbon, Eureka, Sleuth, Zuul and Hystrix.

URL :

1. http://localhost:8100/currencyConverter/feign/{from}-to-{to}/{quantity}

      example  --> http://localhost:8100/currencyConverter/feign/AUD-to-INR/1000

      This endpoint calls the currency-exchange-service in the backend using Feign, Ribbon, Zuul and is fault tolerant using Hystrix.
      
2. http://localhost:8765/currency-converter-service/currencyConverter/feign/{from}-to-{to}/{quantity}

      example  --> http://localhost:8765/currency-converter-service/currencyConverter/feign/EUR-to-INR/500

      This is a Zuul gateway version of above url(1).
