package org.downtimecrew.template.reactSCA

import org.downtimecrew.common.*
import org.downtimecrew.reactSCA.*

def call(Map config = [:]) {
    def wsClean = new wsClean()
    def gitCheckOut = new gitCheckOut()
    def installDependencies = new installDependencies()
    def auditFix = new auditFix()
    def runSonarQubeAnalysis = new runSonarQubeAnalysis()

    wsClean.call(config.cleanWorkspace ?: [:])
    gitCheckOut.call(config.gitCheckout ?: [:])
    installDependencies.call(config.installDeps ?: [:])
    auditFix.call(config.auditFix ?: [:])
    runSonarQubeAnalysis.call(config.sonarQube ?: [:])
}
