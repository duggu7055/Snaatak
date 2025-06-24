package org.downtimecrew.template.reactSCA

import org.downtimecrew.common.*
import org.downtimecrew.reactSCA.*

def call(Map config = [:]) {
    def wsClean = new wsClean()
    def gitCheckOut = new gitCheckOut()
    def installDependencies = new installDependencies()
    def auditFix = new auditFix()
    def runSonarQubeAnalysis = new runSonarQubeAnalysis()

    wsClean.call() // Cleans the workspace
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
}
