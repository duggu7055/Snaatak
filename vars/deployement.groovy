package org.downtimecrew.template.terraformCD

import org.downtimecrew.common.*
import org.downtimecrew.terraform.*

def call(Map config = [:]) {
    def wsClean     = new cleanWorkspace()
    def gitCheckOut = new checkout()
    def fmt         = new terraformFmt()
    def init        = new terraformInit()
    def validate    = new terraformValidate()
    def plan        = new terraformPlan()
    def apply       = new terraformapply()
    def destroy     = new terraformdestroy()

    try {
        wsClean.call()
        gitCheckOut.call([
            branch  : config.gitBranch,
            repoUrl : config.gitRepoUrl,
            creds   : config.gitCredsId
        ])

        init.run(config)
        fmt.run(config)
        validate.run(config)
        plan.run(config)

        if (config.action == 'apply') {
            apply.call([
                envDir     : config.terraformDir,
                awsCredsId : config.awsCredId
            ], this)
        }

        if (config.action == 'destroy') {
            destroy.call([
                envDir     : config.terraformDir,
                awsCredsId : config.awsCredId
            ], this)
        }

    } catch (Exception e) {
        throw e
    }
}
