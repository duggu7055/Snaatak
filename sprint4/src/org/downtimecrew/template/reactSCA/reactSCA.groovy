package org.downtimecrew.template.reactSCA

import org.downtimecrew.common.*
import org.downtimecrew.reactSCA.*

def call(String branch, String url, String creds, String projectKey, String sonarUrl, String sonarSources, String sonarToken) {
    def wsClean = new wsClean()
    def gitCheckOut = new gitCheckOut()    
    def installDependencies = new installDependencies()
    def runSonarQubeAnalysis = new runSonarQubeAnalysis()

    wsClean.call()
    gitCheckOut.call(branch, url, creds)
    installDependencies.call()
    runSonarQubeAnalysis.call(projectKey, sonarUrl, sonarSources, sonarToken)
}

