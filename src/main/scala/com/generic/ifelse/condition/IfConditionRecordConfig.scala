package com.generic.ifelse.condition

import common.util.ReflectionHelper

class IfConditionRecordConfig(configHolder: RecordConfig) {

    /**
     * controller function to update each record config
     * @param configArgs
     */
    def updateRecordConfig(configArgs: String): Unit = {
        val argsArray = configArgs.split(",")
        argsArray.foreach(arg => {
            setConfig(arg)
        })
    }

    /**
     * Function to set config values based on key identification and also validate the keys passed.
     * @param config - config values passed as a comma separated string
     */
    private def setConfig(config: String): Unit = {
        config match {
            case conf if conf.toLowerCase.startsWith("emptykey=.*") => setConfig("emptyKey", conf.substring(9).toLowerCase())
            case conf if conf.toLowerCase.startsWith("allkeyexistcheck=.*") => setConfig("allKeyExistCheck", conf.substring(17).toLowerCase())
            case _ => println(s"Invalid config setting ${config}. Nothing to update.")
        }
    }

    /**
     * Function to set config values to their respective keys and also validate the values passed.
     * @param name
     * @param value
     */
    private def setConfig(name: String, value: String): Unit = {
        if (value == "y")
            ReflectionHelper.setV(configHolder, name, value)
        else if (!value.matches("y|n"))
            println(s"Config value passed for key ${name} is invalid. valid values: Y or N. config ${name} set to default value: ${ReflectionHelper.getV(configHolder, name)}")
    }
}