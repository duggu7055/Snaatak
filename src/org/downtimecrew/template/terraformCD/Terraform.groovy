package org.downtimecrew.template.terraformCD

import org.downtimecrew.common.*
import org.downtimecrew.terraform.*

    def call(Map config = [:]) {
    def wsClean = new cleanWorkspace()
    def gitCheckOut = new checkout()
    def fmt = new fmt()
    def init = new init()
    def validate = new validate()
    def plan = new plan()
    def apply = new apply()

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

        def reportLinks = [
            [name: 'Terraform Plan Output', url: "${env.BUILD_URL}artifact/terraform-plan.txt"]
        ]

        notify.sendNotification([
            status      : 'SUCCESS',
            slackChannel: config.slackChannel,
            slackCredId : config.slackCredId,
            emailTo     : config.emailTo,
            reportLinks : reportLinks
        ], this)

    } catch (Exception e) {
        def reportLinks = [
            [name: 'Terraform Plan Output', url: "${env.BUILD_URL}artifact/terraform-plan.txt"]
        ]

        notify.sendNotification([
            status       : 'FAILURE',
            failureReason: e.message,
            failedStage  : env.STAGE_NAME,
            slackChannel : config.slackChannel,
            slackCredId  : config.slackCredId,
            emailTo      : config.emailTo,
            reportLinks  : reportLinks
        ], this)

        throw e
    }
}
