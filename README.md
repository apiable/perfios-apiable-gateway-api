# Introduction
This is the API which represents the communication towards certain Gateway

## How-To
The concrete implementation of a certain Gateway needs to be implemented towards the [GatewayAdaptor](src%2Fmain%2Fkotlin%2Fio%2Fapiable%2Fgateways%2Fadaptor%2FGatewayAdaptor.kt)

Extend the [GatewayConnectionType](src/main/kotlin/io/apiable/gateways/adaptor/models/conf/GatewayConnectionType.kt) and [GatewayType](src/main/kotlin/io/apiable/gateways/adaptor/models/conf/GatewayType.kt) to your needs by forking this project and creating a pull request when finished.

Any Feedback, adoptions and suggestions to make our developer life easier are very much appreciated and can be recommended in a forked pull request as well.

## Example
```(kotlin)
class AmazonGateway() : GatewayAdaptor {

    override fun createKey(conf: Conf, clientIdOverride: String?, clientSecretOverride: String?, appendToToken: Map<String,String>?): String {
        require(conf is AmazonBasicConf)
        ... specific implementation ...
    }
    ...
}
``
