package org.downtimecrew.template.terraformCD

import org.downtimecrew.common.*
import org.downtimecrew.terraform.*

class Terraform {
    def call(String url, String branch, String creds, String Directory) {
        def wsClean = new wsClean()
        def gitCheckOut = new gitCheckOut()
        def terraformInit = new terraformInit()
        def terraformFmt = new terraformFmt()
        def terraformValidate = new terraformValidate()
        def terraformPlan = new terraformPlan()
        def terraformapply = new terraformapply()

        wsClean.call()

        gitCheckOut.call([
            repoUrl: url,
            branch: branch,
            creds: creds
        ])

        terraformInit.call(Directory)
        terraformFmt.call(Directory)
        terraformValidate.call(Directory)
        terraformPlan.call(Directory)
        terraformapply.call(Directory)
    }
}
