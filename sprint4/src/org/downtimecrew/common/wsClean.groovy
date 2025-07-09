package org.downtimecrew.common

class wsClean {
    def call(Map config = [:]) {
        stage(config.stageName ?: 'Clean Workspace') {
            cleanWs()
        }
    }
}
