package org.downtimecrew.reactSCA

def call(Map config = [:]) {
    stage(config.stageName ?: 'Run SonarQube Analysis') {
        withCredentials([string(credentialsId: config.sonarCredentialId ?: env.SONAR_CRED_ID ?: 'default-sonar-cred', variable: 'SONARQUBE_AUTH_TOKEN')]) {
            sh """
                ${config.sonarScannerPath ?: env.SONAR_SCANNER_PATH ?: '/opt/sonar-scanner/bin/sonar-scanner'} \
                -Dsonar.projectKey=${config.projectKey ?: env.SONAR_PROJECT_KEY ?: 'default-project-key'} \
                -Dsonar.sources=${config.sonarSources ?: env.SONAR_SOURCES ?: 'src'} \
                -Dsonar.javascript.lcov.reportPaths=${config.lcovPath ?: env.LCOV_PATH ?: 'coverage/lcov.info'} \
                -Dsonar.login=$SONARQUBE_AUTH_TOKEN \
                -Dsonar.host.url=${config.sonarUrl ?: env.SONAR_HOST_URL ?: 'http://localhost:9000'}
            """
        }
    }
}
