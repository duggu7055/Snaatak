def call(Map args = [:], steps) {
    if (!args.containsKey('envDir')) {
        steps.error "'envDir' parameter is required"
    }

    def autoApprove = args.get('autoApprove', true)
    def awsCredsId  = args.get('awsCredsId', 'aws-central-account-creds')

    steps.stage("Terraform Destroy") {

        steps.input message: "Confirm Terraform Destroy for '${args.envDir}'?", ok: "Destroy Now"

        steps.withCredentials([
            [$class: 'AmazonWebServicesCredentialsBinding', credentialsId: awsCredsId]
        ]) {
            steps.dir(args.envDir) {
                def destroyCommand = "terraform destroy ${autoApprove ? '-auto-approve' : ''}"
                steps.sh destroyCommand.trim()
            }
        }
    }
}
