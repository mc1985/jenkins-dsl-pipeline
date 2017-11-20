folder('Images')
pipelineJob('Build Images') {

  def repo = 'https://github.com/mc1985/packer-with-ansible.git'
  description("Pipeline for $repo")

  definition {
    cpsScm {
      scm {
        git {
          remote { url(repo) }
          branches('master')
          scriptPath('Jenkinsfile')
          extensions { }  // required as otherwise it may try to tag the repo, which you may not want
        }

      }
    }
  }
}
