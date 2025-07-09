package org.downtimecrew.reactSCA

def call(Map config = [:]) {
    stage(config.stageName ?: 'Install Dependencies') {
        sh config.installCommand ?: 'npm install'
    }
}
