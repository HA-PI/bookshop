$ = require 'jquery'
{alert, confirm} = require 'dialog'
jq_form = require 'jquery-form';
form = jq_form(document)('#form')

form.ajaxForm(
  beforeSubmit: (data, from, options) ->
    form.find('[type=submit]').prop('disabled', true);
  success: ({data, code}, statusText, xhr, $form) ->
    form.find('[type=submit]').prop('disabled', false);
    showAlert data, code is 200
  fail: (responseText, statusText, xhr, $form) ->
    console.log responseText, statusText, xhr, $form
  dataType: 'json'
);

alertDiv = $('#alert')
showAlert = (text, success=true) ->
  if success isnt yes
    alertDiv.removeClass('alert-success').addClass('alert-danger')
  else
    alertDiv.removeClass('alert-danger').addClass('alert-success')
  alertDiv.find('[role=text]').text(text)
  alertDiv.fadeIn('normal')

$('#img').change (e) ->
  img = $(@)
  files = $(@).prop('files')
  fr = new FileReader();
  fr.readAsDataURL(files[0]);
  fr.onload = (e) ->
    @.result
