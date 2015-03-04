from setuptools import setup, find_packages

version = '1.0.0'
with open('version') as f:
    version = f.readline()

setup(
    name='corenlp',
    version='1.0',
    # package_dir={'': 'build/thrift/py'},
    # packages=find_packages('build/thrift/py/corenlp'),
    packages=[
        'corenlp'
    ],
    include_package_data=True,
    description='Thrift client for Stanford CoreNLP service',
    author='Pablo Torres',
    author_email='pablo.torres@insight-centre.org',
    url="https://github.com/ptorrestr/StanfordCoreNLPService"
)
