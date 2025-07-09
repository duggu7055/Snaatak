package org.downtimecrew.reactSCA

def call(Map config = [:]) {
    stage(config.stageName ?: 'Audit and Fix Vulnerabilities') {
        sh config.auditCommand ?: 'npm audit fix || true'
    }
}
