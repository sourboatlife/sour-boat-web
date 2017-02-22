var shell = {
  cat: function(words) {
    var result = "";
    words.slice(1).forEach(function(path) {
      if (shell.pathIsValid(path))
        result += shell.pathToNode(path).html();
    });
    return result;
  },

  cd: function(words) {
    // handle .. and .
    if (this.pathIsValid(words[1])) {
      if (words[1][0] === '/')
      {
        this.ENV.CWD = words[1];
      }
      else
      {
//      stripExtraSlashes();
        this.ENV.CWD += words[1];
      }

      if (this.ENV.CWD[this.ENV.CWD.length-1] !== '/')
        this.ENV.CWD += '/';

//    updatePrompt();
    }
    return '';
  },

  clear: function(words) {
    this.terminalOutput().text('');
    return '';
  },

  echo: function(words) {
    words.shift();
    return words.join(' ');
  },

  find: function(words) {
    return '';
  },

  ls: function(words) {
    var node = this.pathToNode((words.length < 2) ? this.ENV.CWD : words[1]);

    // iterate over:
    var result = "";
    node.children().each(function() {
      result += this.title + "\n";
    });

    //construct string to return
    return result;
  },

  man: function(words) {
    return '';
  },

  bad_command_or_file_name: function (words) {
    return 'sbsh: ' + words[0] + ': command not found';
  },

/*
ls
  SourBoatLife/

cd SourBoatLife

ls
  Episode 1/
  Episode 2/
  Episode 3/

ls -l
 -rw-r--r--     1 sbw  staff     10824  Jan 8  2017   Episode 1/

cd Episode 3

ls
  title
  description
  tags
  videos/
    part 1
    part 2

cat title
  SourBoatJavascript: Adding a fake terminal to the web page, because mice are for pansies!
*/

  terminalOutput: function() { return $('.terminal.output'); },

  terminalInput:  function() { return $('#cmd'); },

  rootDir: function() { return $("#data"); },

  pathToNode: function(path) {
    if (typeof(path) === 'undefined' || path === null || path.length < 1) return this.ENV.CWD;

    if (path[0] !== '/')
      path = this.ENV.CWD + path;

    var path_parts = path.split('/');
    var root = this.rootDir();
    while (path_parts.length != 0) {
      var current_chunk = path_parts.shift();
      if (current_chunk.length) {
        root = root.children("[title='" + current_chunk + "']");
      }
    }

    return root;
  },

  pathIsValid: function(path) {
    return this.pathToNode(path) !== null;
  },

  // CWD always ends in /
  ENV: { CWD: "/", USER: "anon", HOST: "sourboatlife.com", PS1: "\\u@\\h\\w\\$ " },

  eval: function (text) {
    var words = text.split(/ /);
    switch (words[0]) {
      case 'cat':   return this.cat(words);
      case 'cd':    return this.cd(words);
      case 'clear': return this.clear(words);
      case 'echo':  return this.echo(words);
      case 'find':  return this.find(words);
      case 'ls':    return this.ls(words);
      case 'man':   return this.man(words);
      default:      return this.bad_command_or_file_name(words);
    }
  },

  print: function(output) {
    this.terminalOutput().html(this.terminalOutput().text() + '\n' + output);
    this.terminalInput().val('');
    this.updatePrompt();
  },

  read: function() {
    this.print(this.eval(this.validateInput(this.terminalInput().val())));
  },

  validateInput: function(input) {
    // implement this
    return input;
  },

  updatePrompt: function() {
    var prompt = this.ENV.PS1
      .replace("\\h", this.ENV.HOST)
      .replace("\\u", this.ENV.USER)
      .replace("\\w", this.ENV.CWD)
      .replace("\\$", "$");
    console.log("new prompt: " + prompt);
    $('#prompt').text(prompt);
  }
};

$(document).ready(function () {
  shell.updatePrompt();
  shell.terminalInput().keypress(function(event) {
    /* when they hit enter */
    if (event.which === 13) {
      shell.read();
    }
  });
});