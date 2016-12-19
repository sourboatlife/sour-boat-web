var shell = {
  cat: function(words) {
    return '';
  },

  cd: function(words) {
    return '';
  },

  clear: function(words) {
    this.terminalOutput().html('');
    return '';
  },

  echo: function(words) {
    return words.slice(1).join(' ');
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

  badCommandOrFileName: function (words) {
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
      default:      return this.badCommandOrFileName(words);
    }
  },

  print: function (output) {
    this.terminalOutput().append('<pre>' + output + '</pre>');
  },

  read: function() {
    // echo the command back to the user
    var commandLine = this.terminalInput().val();
    this.print($("label[for='cmd']").text() + commandLine);

    // write the result of running the command
    this.print(this.eval(this.validateInput(commandLine)));

    // clear the line
    this.terminalInput().val('');
  },

  validateInput: function(input) {
    // implement this
    return input;
  }
};

$(document).ready(function () {
  $('#cmd').on('keydown', function(e) {
    if (e.keyCode == 13)
      shell.read();
  });
});