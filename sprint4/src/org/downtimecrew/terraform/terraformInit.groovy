package org.downtimecrew.terraform

def call(String Directory) {
    stage("Terraform init") {
        script {
            sh """
                cd ${Directory}
                terraform init -reconfigure
            """
        }
    }
}
