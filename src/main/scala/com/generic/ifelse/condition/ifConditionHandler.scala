package com.generic.ifelse.condition

private case class RecordConfig(
    var emptyKey:         Boolean = false,
    var allKeyExistCheck: Boolean = false)

object ifConditionHandler {

    // config keys/if col1=val1 && col2.
    def evaluateIfCondition[A <: collection.Map[String, String]](expression: String, data: A): String = {
        var dataConfig = RecordConfig()
        val recordConfigSetter = new IfConditionRecordConfig(dataConfig)
        if (expression.contains("/")) 
            recordConfigSetter.updateRecordConfig(expression.substring(0, expression.indexOf("/")))
        
        ""
    }

}