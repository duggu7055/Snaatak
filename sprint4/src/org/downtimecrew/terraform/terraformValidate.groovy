package org.downtimecrew.terraform

def call(String Directory) {
    stage("Terraform validate") {
        script {
            sh """
                cd ${Directory}
                terraform validate
            """
        }
    }
}
