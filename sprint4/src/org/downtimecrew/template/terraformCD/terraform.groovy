package org.downtimecrew.template.terraformCD
import org.downtimecrew.common.*
import org.downtimecrew.terraform.*

def call(String url, String branch, String creds, String Directory) {

    // Create instances of required classes
     def wsClean=new wsClean()
     def gitCheckOut = new gitCheckOut()
     def terraformInit = new terraformInit()
     def terraformFmt = new terraformFmt()
     def terraformValidate = new terraformValidate()
     def terraformPlan = new terraformPlan()
     def terraformapply = new terraformapply()


    // Call methods with correct arguments
    wsClean.call()
    gitCheckOut.call(url, branch, creds)
    terraformInit.call(Directory)
    terraformFmt.call(Directory)
    terraformValidate.call(Directory)
    terraformPlan.call(Directory)
    terraformapply.call(Directory)

}
