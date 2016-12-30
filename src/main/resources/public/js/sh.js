var shell = {
  cat: function(words) {
    return '';
  },

  cd: function(words) {
    return '';
  },

  clear: function(words) {
    this.terminalOutput().text('');
    return '';
  },

  echo: function(words) {
    return '';
  },

  find: function(words) {
    return '';
  },

  ls: function(words) {
    return '';
  },

  man: function(words) {
    return '';
  },

  bad_command_or_file_name: function (words) {
    return 'sbsh: ' + words[0] + ': command not found';
  },

  terminalOutput: function() { return $('.terminal.output'); },

  terminalInput:  function() { return $('#cmd'); },

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
    this.terminalOutput().text(this.terminalOutput().text() + '\n' + output);
    this.terminalInput().val('');
  },

  read: function() {
    this.print(this.eval(this.validateInput(this.terminalInput().val())));
  },

  validateInput: function(input) {
    // implement this
    return input;
  }
};

$(document).ready(function () {
  shell.terminalInput().keypress(function(event) {
    /* when they hit enter */
    if (event.which === 13) {
      shell.read();
    }
  });
});