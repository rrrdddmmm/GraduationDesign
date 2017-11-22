#-*-coding: UTF-8 -*-
from flask import Flask
from flask import render_template
from flask import request
from flask import redirect
from flask import url_for
from flask import make_response,abort
from werkzeug.routing import BaseConverter
from werkzeug.utils import secure_filename
from os import path
from flask.ext.script import Manager

app = Flask(__name__)
manager = Manager(app)


@app.route("/")
def hello():
    return render_template("index.html",title = 123456)

@app.route("/services")
def services():
    return 'Services'

@app.route("/about")
def about():
    return 'About'


# 动态路由
@app.route("/user/<int:username>")
@app.route("/our-works/<int:username>")
def user(username):
    return 'User %d' % username

@app.route('/login',methods=['GET','POST'])
def login():
    # if request.method == 'GET':
    #     return render_template("login.html")
    username = '12345'
    if request.method == 'POST':
        username = request.form['username']
        password = request.form['password']
    return render_template("login.html",name=username,method=request.method)

# 文件上传
# IOError: [Errno 13] Permission denied: 'E:\\123456'
@app.route('/upload',methods=['GET','POST'])
def upload(): 
    if request.method == 'POST':
        f = request.files['file']
        basepath = path.abspath(path.dirname(__file__))
        upload_path = path.join(basepath, 'E:\\123456')
        f.save(upload_path, secure_filename(f.filename))
        return redirect(url_for('upload'))
    return render_template('upload.html')

# 操作cookies
@app.route('/indexcookies')
def indexcookies():
    abort(404)
    request.cookies['']
    response = make_response(render_template('index.html',title="欢迎光临"))
    response.set_cookie('username', '123')
    # return render_template('index.html',title="欢迎光临")

@app.errorhandler(404)
def page_not_find(error):
    return render_template('404.html'), 404

# pip freeze > requirments.txt //项目依赖包的导出
# pip install -r requirments.txt //项目依赖包的安装
def main():
    # debug=True 修改后自动加载
    # app.run(debug=True)
    manager.run()

if __name__ == '__main__':
    main()
