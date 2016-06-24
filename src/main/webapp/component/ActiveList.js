//首页 活动列表
import React from 'react';
import ReactDOM from 'react-dom';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import injectTapEventPlugin from 'react-tap-event-plugin';

import MyTheme from './MyTheme.js';
import Formate from './Formate.js';

import {List, ListItem} from 'material-ui/List';
import {tealA700} from 'material-ui/styles/colors';
import Subheader from 'material-ui/Subheader';
import Divider from 'material-ui/Divider';
import Avatar from 'material-ui/Avatar';
import Paper from 'material-ui/Paper';

import ActionAssignment from 'material-ui/svg-icons/action/assignment';
import FloatingActionButton from 'material-ui/FloatingActionButton';
import ContentAdd from 'material-ui/svg-icons/content/add';

injectTapEventPlugin();


//首页活动列表
let back={
    backgroundColor:'green',
}
let addButtonPos={
    position:'fixed',
    right:'10px',
    bottom:'15%',
    zIndex:999
}

class ActiveList extends React.Component{
    constructor(props){
        super(props);
        this.componentDidMount=this.componentDidMount.bind(this);
        this.state={
            data:[],
            status:0
        }
    }

    componentDidMount(){
        $.get("../java/getActiveList.jsp",function (result) {
            this.setState({
                data:result.data,
                status:result.status
            });  
        }.bind(this));
    }

    render(){
        return(
        
        <div>
            <Paper zDepth={0}>
                <List>
                    {this.state.data.map(function(result,index){
                          return (
                            <div key={result.activeId}>
                                {
                                    Formate.formate(result.startTime,'date')===Formate.formate(new Date(),'date')?//如果是今天
                                    <Subheader style={{backgroundColor:'#00BFA5',color:'white'}}>今天 {Formate.formate(new Date(),'date')}</Subheader>
                                    :
                                    <Subheader>{Formate.formate(result.startTime,'date')}</Subheader>

                                }
                                <ListItem
                                    leftAvatar={<Avatar icon={<ActionAssignment />} backgroundColor={tealA700} />}
                                    primaryText={Formate.formate(result.startTime,'time')+"-"+Formate.formate(result.endTime,'time')}
                                    secondaryText={result.activeTheme}
                                    href={"detail.html?activeId="+result.activeId}
                                />                                
                                <Divider insert={true} />
                            </div>
                          );
                    })}
                </List>
            </Paper>
            <FloatingActionButton 
                style={addButtonPos} 
                secondary={true} 
                href="add.html"
                linkButton={true}
            >
              <ContentAdd />
            </FloatingActionButton>
        </div> 
        )
    }
}

ReactDOM.render(
   <MuiThemeProvider muiTheme={MyTheme}>
    <ActiveList />
   </MuiThemeProvider>,
   document.getElementsByClassName('home')[0] 
);
