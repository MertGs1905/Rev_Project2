import { IUser } from './User';
import { IRating } from './Rating';

export interface IPost {
    postId?: number;
    userid: number;
    post: string;
    rating: number[];
}
