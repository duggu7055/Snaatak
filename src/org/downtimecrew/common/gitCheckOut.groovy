package org.downtimecrew.common

class gitCheckOut {
    def call(Map config = [:]) {
        stage(config.stageName ?: 'Checkout Code') {
            checkout([
                $class: 'GitSCM',
                branches: [[name: config.branch ?: env.GIT_BRANCH ?: 'main']],
                userRemoteConfigs: [[
                    url: config.repoUrl ?: env.GIT_REPO_URL ?: 'https://github.com/OT-MICROSERVICES/frontend.git',
                    credentialsId: config.creds ?: env.GIT_CREDS_ID ?: 'default-credentials-id'
                ]]
            ])
        }
    }
}
