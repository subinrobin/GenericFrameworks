package common.util

/*
 * operates on an instance of a class, such as set/get fields
 */
object ReflectionHelper {
    /*
     * invoke the "getter" for a field in the class instance
     */
    def getV(ref: AnyRef, name: String): Any = ref.getClass.getMethods.find(_.getName == name).get.invoke(ref)

    /*
     * invoke the "setter" for a field in the class instance
     */
    def setV(ref: AnyRef, name: String, value: Any): Unit = ref.getClass.getMethods.find(_.getName == name + "_$eq").get.invoke(ref, value.asInstanceOf[AnyRef])
}