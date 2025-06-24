package org.downtimecrew.template.reactSCA

import org.downtimecrew.common.*
import org.downtimecrew.reactSCA.*

def call(Map config = [:]) {
    def wsClean = new wsClean()
    def gitCheckOut = new gitCheckOut()
    def installDependencies = new installDependencies()
    def auditFix = new auditFix()
    def runSonarQubeAnalysis = new runSonarQubeAnalysis()
    def notify = new notify()

    try {
        wsClean.call()
        gitCheckOut.call([
            branch: config.gitBranch,
            repoUrl: config.gitRepoUrl,
            creds: config.gitCredsId
        ])
        installDependencies.call([
            installCommand: 'npm install'
        ])
        auditFix.call([
            auditCommand: 'npm audit fix || true'
        ])
        runSonarQubeAnalysis.call([
            projectKey: config.sonarProjectKey,
            sonarUrl: config.sonarUrl,
            sonarSources: config.sonarSources,
            sonarCredentialId: config.sonarCredsId,
            sonarScannerPath: config.sonarScannerPath,
            lcovPath: config.lcovPath
        ])

        notify([
            status: 'SUCCESS',
            buildTrigger: env.BUILD_USER ?: 'Unknown',
            slackChannel: config.slackChannel ?: '#general',
            slackCredId: config.slackCredId ?: 'default-slack-cred',
            emailTo: config.emailTo ?: 'team@example.com',
            reportLinks: config.reportLinks ?: []
        ], steps)
    } catch (Exception e) {
        notify([
            status: 'FAILURE',
            buildTrigger: env.BUILD_USER ?: 'Unknown',
            failureReason: e.message,
            failedStage: env.STAGE_NAME,
            slackChannel: config.slackChannel ?: '#general',
            slackCredId: config.slackCredId ?: 'default-slack-cred',
            emailTo: config.emailTo ?: 'team@example.com',
            reportLinks: config.reportLinks ?: []
        ], steps)
        throw e
    }
}
