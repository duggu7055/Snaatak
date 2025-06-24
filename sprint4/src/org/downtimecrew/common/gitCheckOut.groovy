package org.downtimecrew.common

def call(String branch, String url, String creds) {
    stage('Checkout Code') {
        git branch: branch, url: url, credentialsId: creds
    }
}

