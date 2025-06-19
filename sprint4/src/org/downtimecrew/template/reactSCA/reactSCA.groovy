package org.downtimecrew.template.reactSCA

import org.downtimecrew.common.*
import org.downtimecrew.reactSCA.*

def call(String branch, String url, String creds, String projectKey, String sonarUrl, String sonarSources, String sonarToken) {
    def gitCheckOut = new gitCheckOut()
    def wsClean = new wsClean()
    def installDependencies = new InstallDependencies()
    def runSonarQubeAnalysis = new RunSonarQubeAnalysis()

    wsClean.call()
    gitCheckOut.call(branch, url, creds)
    installDependencies.call()
    runSonarQubeAnalysis.call(projectKey, sonarUrl, sonarSources, sonarToken)
}

